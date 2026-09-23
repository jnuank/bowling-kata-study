// The main entry point.
def main(): Unit \ IO =
    println("Hello World!")

def score(rolls: List[Int32]): Int32 = scoringRolls(rolls, 1) |> List.flatten |> List.sum

def scoringRolls(rolls: List[Int32], frame: Int32): List[List[Int32]] = 
    if (frame > 10)
        (Nil:List[List[Int32]])
    else match rolls {
        case a :: b :: rest if a + b == 10 => 
            (a :: b :: List.take(1, rest)) :: scoringRolls(rest, frame + 1)
        case a :: b :: rest => 
            (a :: b :: Nil) :: scoringRolls(rest, frame + 1)
        case _ => 
            Nil
    }
