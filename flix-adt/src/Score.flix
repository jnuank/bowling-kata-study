enum Frame with ToString {
    case Strike(Int32, Int32, Int32),
    case Spare(Int32, Int32, Int32),
    case Open(Int32, Int32)
}

def parse(rolls: List[Int32]): List[Frame] = go(rolls, 10)

def go(rolls: List[Int32], left: Int32): List[Frame] =
    if (left == 0) Nil
    else match rolls {
        case 10 :: a :: b :: rest =>
            Frame.Strike(10, a, b) :: go(a :: b :: rest, left - 1)
        case a :: b :: c :: rest if a + b == 10 =>
            Frame.Spare(a, b, c) :: go(c :: rest, left - 1)
        case a :: b :: rest =>
            Frame.Open(a, b) :: go(rest, left - 1)
        case _ => Nil
    }

def points(f: Frame): Int32 = match f {
    case Frame.Strike(a, b, c) => a + b + c
    case Frame.Spare(a, b, c) => a + b + c
    case Frame.Open(a, b)   => a + b
}

def score(rolls: List[Int32]): Int32 =
    parse(rolls) |> List.map(points) |> List.sum
