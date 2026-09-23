// The main entry point.
def main(): Unit \ IO =
    println("Hello World!")

def score(rolls: List[Int32]): Int32 = List.foldLeft((acc, x) -> acc + x, 0, rolls)