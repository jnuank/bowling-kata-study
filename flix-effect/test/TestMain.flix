@Test   
def testAllGutters(): Unit \ {Bonus, Assert} = Assert.assertEq(expected = 0, score(List.repeat(20, 0)))

@Test
def testOneFrameSpare(): Unit \ {Bonus, Assert} = Assert.assertEq(expected = 20, score((5::5::5::Nil) ::: List.repeat(17, 0)))