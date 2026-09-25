@Test
def test01(): Unit \ Assert = Assert.assertEq(expected = 2, 1 + 1)

@Test
def testGutter(): Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20, 0)))