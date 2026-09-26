@Test
def testAllGutter(): Unit \ Assert = Assert.assertEq(expected = 0, score(List.repeat(20,0)))

def testAllOpen(): Unit \ Assert = Assert.assertEq(expected = 20, score(List.repeat(20,1)))