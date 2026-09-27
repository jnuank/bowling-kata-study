type alias Roll = Int32

enum Frame {
    case Strike,
    case Spare,
    case Open(Roll, Roll)
}

eff Bonus {
    def nextRolls(n: Int32): List[Roll]
}

def frames(n: Int32, rolls: List[Roll]): List[(Frame, List[Roll])] =
    if (n > 10) Nil else match rolls {
        case 10 :: rest => (Frame.Strike, rest) :: frames(n + 1, rest)
        case a :: b :: rest if a + b == 10 => (Frame.Spare, rest) :: frames(n + 1, rest)
        case a :: b :: rest => (Frame.Open(a, b), Nil) :: frames(n + 1, rest)
        case _ => Nil
    }

def _score(frame: Frame): Int32 \ Bonus =
    match frame {
        case Frame.Strike => 10 + List.sum(Bonus.nextRolls(2))
        case Frame.Spare => 10 + List.sum(Bonus.nextRolls(1))
        case Frame.Open(a, b) => a + b
    }

def runScore(scored: (Frame, List[Roll])): Int32 =
    let (frame, following) = scored;
    run {
        _score(frame)
    } with handler Bonus {
        def nextRolls(n, resume) =
            resume(List.take(n, following))
    }

def score(rolls: List[Roll]): Int32 =
    rolls
    |> frames(1)
    |> List.map(runScore)
    |> List.sum
