type alias Bonus = Int32
type alias Roll = Int32

mod Frame {
    enum Frame with ToString {
        case Strike(Bonus, Bonus)
        case Spare(Bonus)
        case Open(Roll, Roll)
    }

    instance Scoreable[Frame] {
        pub def score(frame: Frame) : Int32 = match frame {
            case Frame.Strike(bonus1, bonus2) => 10 + bonus1 + bonus2
            case Frame.Spare(bonus) => 10 + bonus
            case Frame.Open(roll1, roll2) => roll1 + roll2
        }
    }

}


trait Scoreable[t] {
    pub def score(x: t) : Int32
}


def frames(n: Int32, rolls: List[Int32]) : List[Frame] = 
    if (n > 10 ) Nil else match rolls {
        case 10 :: a :: b :: rest => Frame.Strike(a, b) :: frames(n + 1, a :: b ::rest)
        case a :: b :: c :: rest if a + b == 10 => Frame.Spare(c) :: frames(n + 1, c :: rest)
        case a :: b :: rest => Frame.Open(a, b) :: frames(n + 1, rest)
        case Nil => Nil
        case _ => Nil
    }

def score(rolls: List[Int32]) : Int32 =
    rolls
    |> frames(1)
    |> List.sumWith(Scoreable.score)