@Test
def testAllGutters(): Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20, 0)))

@Test
def testOneFrameSpare(): Unit \ Assert = Assert.assertEq(expected = 20, score((5::5::5::Nil) ::: List.repeat(17, 0)))

@Test
def testOneFrameStrike(): Unit \ Assert = Assert.assertEq(expected = 28, score((10::4::5::Nil) ::: List.repeat(17, 0)))
