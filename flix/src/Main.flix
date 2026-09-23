// The main entry point.
def main(): Unit \ IO =
    println("Hello World!")

def score(rolls: List[Int32]): Int32 = scoringRolls(rolls, 1) |> List.flatten |> List.sum

def scoringRolls(rolls: List[Int32], frame: Int32): List[List[Int32]] = 
    if (frame > 10)
        (Nil:List[List[Int32]])
    else
        let n = if (List.take(2, rolls) |> List.sum == 10) 3 else 2;
        if (List.take(2, rolls) |> List.sum == 10) (List.take(n, rolls) :: scoringRolls(List.drop(2, rolls), frame + 1))
        else (List.take(n, rolls) ::scoringRolls(List.drop(2, rolls), frame + 1))