@Test
def testGutterOnly(): Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20, 0)))

@Test
def testOpenOneFrame(): Unit \ Assert = Assert.assertEq(expected = 3, score((1::2::Nil) ::: List.repeat(18, 0)))

@Test
def testSpareOneFrame(): Unit \ Assert = Assert.assertEq(expected = 23, score((5::5::4::5::Nil) ::: List.repeat(16, 0)))

@Test
def testAllSpare(): Unit \ Assert = Assert.assertEq(expected = 150, score(List.repeat(21, 5)))

@Test
def testLastFrameSpare(): Unit \ Assert = Assert.assertEq(expected = 15, score(List.repeat(18, 0) ::: (5::5::5::Nil)))

@Test
def testStrikeOneFrame(): Unit \ Assert = Assert.assertEq(expected = 28, score((10::4::5::Nil) ::: List.repeat(16, 0)))

@Test
def testAllStrike(): Unit \ Assert = Assert.assertEq(expected = 300, score(List.repeat(12, 10)))

@Test
def testLastFrameStrike(): Unit \ Assert = Assert.assertEq(expected = 30, score(List.repeat(18, 0) ::: (10::10::10::Nil)))