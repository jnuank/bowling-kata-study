type alias Bonus = Int32
type alias Roll = Int32

enum Frame with ToString {
    case Spare(Bonus)
    case Open(Roll, Roll)
}

trait Scoreable[t] {
    pub def score(x: t) : Int32
}

instance Scoreable[Frame] {
    pub def score(frame: Frame) : Int32 = match frame {
        case Frame.Spare(bonus) => 10 + bonus
        case Frame.Open(roll1, roll2) => roll1 + roll2
    }
}

def frames(rolls: List[Int32]) : List[Frame] = 
    match rolls {
        case Nil => Nil
        case a :: b :: c :: rest if a + b == 10 => Frame.Spare(c) :: frames(c :: rest)
        case a :: b :: rest=> Frame.Open(a, b) :: frames(rest)
        case _ => Nil
    }

def score(rolls: List[Int32]) : Int32 = rolls |> frames |> List.foldLeft((acc, frame) -> acc + Scoreable.score(frame), 0)