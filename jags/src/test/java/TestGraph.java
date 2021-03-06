package test.java;

import main.java.core.Edge;
import main.java.core.Graph;
import main.java.core.Vertex;
import main.java.edgetype.Street;
import junit.framework.TestCase;

public class TestGraph extends TestCase {
	public void testBasic() throws Exception {
		Graph gg = new Graph();
		assertNotNull(gg);
	}
	
	public void testAddVertex() throws Exception {
		Graph gg = new Graph();
		Vertex a = gg.addVertex( "A" );
		assertEquals( a.label, "A" );
	}
	
	public void testGetVertex() throws Exception {
		Graph gg = new Graph();
		Vertex a = gg.addVertex( "A" );
		Vertex b = gg.getVertex( "A" );
		assertEquals( a, b );
	}
	
	public void testAddEdge() throws Exception {
		Graph gg = new Graph();
		gg.addVertex( "A" );
		gg.addVertex( "B" );
		Edge ee = gg.addEdge( "A", "B", new Street(1) );
		assertNotNull( ee );
	}
}
