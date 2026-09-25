enum Frame with ToString {
    case Strike(Int32, Int32),
    case Spare(Int32),
    case Open(Int32, Int32)
}

enum Frames with ToString {
    case Nil,
    case Cons(Frame, Frames)
}

def frameScore(frame: Frame): Int32 = match frame {
    case Frame.Strike(a, b) => 10 + a + b
    case Frame.Spare(a) => 10 + a
    case Frame.Open(a, b) => a + b
}

def parse(rolls: List[Int32]): Frames =
    def go(rs: List[Int32], left: Int32): Frames =
        match (left, rs) {
            case (0, _) => Frames.Nil
            case (_, 10 :: a :: b :: rest) =>
                Frames.Cons(Frame.Strike(a, b), go(a::b::rest, left - 1))
            case (_, a :: b :: c :: rest) if a + b == 10 =>
                Frames.Cons(Frame.Spare(c), go(c::rest, left - 1))
            case (_, a :: b :: rest) =>
                Frames.Cons(Frame.Open(a, b), go(rest, left - 1))
            case _ => Frames.Nil

    };
    go(rolls, 10)


def score(rolls: List[Int32]): Int32 = 
    def go(frames: Frames): Int32 = 
        match frames {
            case Frames.Nil => 0
            case Frames.Cons(frame, rest) => frameScore(frame) + go(rest)
        };
    go(parse(rolls))
