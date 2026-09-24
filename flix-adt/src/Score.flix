def score(rolls: List[Int32]) : Int32 =
    if (List.isEmpty(rolls))
        0
    else 
        if (List.take(2, rolls) |> List.sum == 10)
            List.take(3, rolls) |> List.sum + score(List.drop(2, rolls))
        else
            List.sum(List.take(2, rolls)) + score(List.drop(2, rolls))