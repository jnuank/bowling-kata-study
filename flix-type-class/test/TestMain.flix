@Test
def testAllGutter(): Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20,0)))

@Test
def testAllOpen(): Unit \ Assert = Assert.assertEq(expected = 20, score(List.repeat(20,1)))

@Test
def testOneSpare(): Unit \ Assert = Assert.assertEq(expected = 20, score((5::5::5::Nil) ::: List.repeat(17,0)))
