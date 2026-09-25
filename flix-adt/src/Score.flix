enum Frame with ToString {
    case Strike(Int32, Int32),
    case Spare(Int32),
    case Open(Int32, Int32)
}

def parse(rolls: List[Int32]): List[Frame] =
    def go(rs: List[Int32], left: Int32): List[Frame] =
        match (left, rs) {
            case (0, _) => Nil
            case (_, 10 :: a :: b :: rest) =>
                Frame.Strike(a, b) :: go(a :: b :: rest, left - 1)
            case (_, a :: b :: c :: rest) if a + b == 10 =>
                Frame.Spare(c) :: go(c :: rest, left - 1)
            case (_, a :: b :: rest) =>
                Frame.Open(a, b) :: go(rest, left - 1)
            case _ => Nil
        };

    go(rolls, 10)

def points(f: Frame): Int32 = match f {
    case Frame.Strike(a, b) => 10 + a + b
    case Frame.Spare(a) => 10 + a
    case Frame.Open(a, b)   => a + b    
}

def score(rolls: List[Int32]): Int32 =
    rolls
    |> parse
    |> List.map(points)
    |> List.sum
