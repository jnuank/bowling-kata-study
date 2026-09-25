@Test
def testGutter(): Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20, 0)))

@Test
def testOneSpare(): Unit \ Assert = Assert.assertEq(expected = 18, score((5::5::4::Nil) ++ List.repeat(17, 0)))