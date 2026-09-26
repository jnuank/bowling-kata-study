@Test
def testGutter(): Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20, 0)))

@Test
def testOneSpare(): Unit \ Assert = Assert.assertEq(expected = 20, score((5::5::5::Nil) ++ List.repeat(17, 0)))

@Test
def testLastFrameSpare(): Unit \ Assert = Assert.assertEq(expected = 15, score((List.repeat(18, 0)) ++ (5::5::5::Nil)))

@Test
def testOneStrike(): Unit \ Assert = Assert.assertEq(expected = 60, score((10::10::10::Nil) ++ List.repeat(17, 0)))

@Test
def testLastFrameStrike(): Unit \ Assert = Assert.assertEq(expected = 30, score((List.repeat(18, 0)) ++ (10::10::10::Nil)))

@Test
def testAllSpares(): Unit \ Assert = Assert.assertEq(expected = 150, score((List.repeat(21, 5))))

@Test
def testPerfectGame(): Unit \ Assert = Assert.assertEq(expected = 300, score((List.repeat(12, 10))))