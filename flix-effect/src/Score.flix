type alias Roll = Int32

enum Frame {
    case Strike,
    case Spare,
    case Open(Roll, Roll)
}

eff Bonus {
    def nextRoll(): Roll
}

def _score(frame: Frame): Int32 \ Bonus =
    match frame {
        case Frame.Strike => 10 + Bonus.nextRoll() + Bonus.nextRoll()
        case Frame.Spare => 10 + Bonus.nextRoll()
        case Frame.Open(a, b) => a + b
    }

def runScore(scoredFrame: (Frame, List[Roll])): Int32 =
    let (frame, following) = scoredFrame;
    region rc {
        let remaining = Ref.fresh(rc, following);
        run {
            _score(frame)
        } with handler Bonus {
            def nextRoll(_, resume) =
                match Ref.get(remaining) {
                    case roll :: rest => {
                        Ref.put(rest, remaining);
                        resume(roll)
                    }
                    case Nil => resume(0)
                }
        }
    }

def _frames(n: Int32, rolls: List[Roll]): List[(Frame, List[Roll])] =
    if (n > 10) Nil else match rolls {
        case 10 :: rest =>
            (Frame.Strike, rest) :: _frames(n + 1, rest)
        case a :: b :: rest if a + b == 10 =>
            (Frame.Spare, rest) :: _frames(n + 1, rest)
        case a :: b :: rest =>
            (Frame.Open(a, b), Nil) :: _frames(n + 1, rest)
        case _ => Nil
    }

def frames(rolls: List[Roll]): List[(Frame, List[Roll])] = _frames(1, rolls)

def scores(scoredFrames: List[(Frame, List[Roll])]): List[Int32] =
    scoredFrames |> List.map(runScore)

def score(rolls: List[Roll]): Int32 =
    rolls
    |> frames
    |> scores
    |> List.sum
