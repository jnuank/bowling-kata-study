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

def runScore(frame: Frame, following: List[Roll]): Int32 =
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

def scoreFrames(n: Int32, rolls: List[Roll]): Int32 =
    if (n > 10) 0 else match rolls {
        case 10 :: rest =>
            runScore(Frame.Strike, rest) + scoreFrames(n + 1, rest)
        case a :: b :: rest if a + b == 10 =>
            runScore(Frame.Spare, rest) + scoreFrames(n + 1, rest)
        case a :: b :: rest =>
            runScore(Frame.Open(a, b), Nil) + scoreFrames(n + 1, rest)
        case _ => 0
    }

def score(rolls: List[Roll]): Int32 = scoreFrames(1, rolls)
