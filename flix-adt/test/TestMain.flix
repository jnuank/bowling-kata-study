
@Test
def testGutterOnly() : Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20, 0)))

@Test
def testOneFrameSpare(): Unit \ Assert = Assert.assertEq(expected = 20, score(List.repeat(3, 5) ::: List.repeat(17, 0)))

