type alias Roll = Int32

enum Frame {
    case Strike,
    case Spare,
    case Open(Roll, Roll)
}

eff Bonus {
    def nextRoll(): Roll
}

def frames(n: Int32, rolls: List[Roll]): List[Frame] = 
    if (n > 10 ) Nil else match rolls {
        case a :: b :: c :: rest if a + b == 10 => Frame.Spare :: frames(n + 1, c :: rest)
        case a :: b :: rest => Frame.Open(a, b) :: frames(n + 1, rest)
        case _ => Nil
    }


def _score(frame: Frame): Int32 \ Bonus = 
    match frame {
        case Frame.Strike => 10 + Bonus.nextRoll() + Bonus.nextRoll()
        case Frame.Spare => 10 + Bonus.nextRoll()
        case Frame.Open(a, b) => a + b
    }

def runScore(frame: Frame): Int32 \ Bonus =
    run {
        _score(frame)
    } with handler Bonus {
        def nextRoll(_, resume) = 
            resume(10)
    }

def score(rolls: List[Roll]): Int32 \ Bonus =
    rolls
    |> frames(1)
    |> List.map(runScore)
    |> List.sum