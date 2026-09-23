@Test
def gutterOnly(): Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20, 0)))

@Test
def openOneFrame(): Unit \ Assert = Assert.assertEq(expected = 3, score((1::2::Nil) ::: List.repeat(18, 0)))