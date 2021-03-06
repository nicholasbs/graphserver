package main.java.spt;

import java.util.Collection;
import java.util.HashMap;

import main.java.core.AbstractVertex;
import main.java.core.Graph;
import main.java.core.State;
import main.java.core.Vertex;



public class ShortestPathTree extends Graph {
	private static final long serialVersionUID = -3899613853043676031L;
	HashMap<Vertex,AbstractVertex> vertices;
    
    public ShortestPathTree() {
        vertices = new HashMap<Vertex,AbstractVertex>();
    }
    
    public SPTVertex addVertex( Vertex vv, State ss, double weightSum ) {
        SPTVertex ret = new SPTVertex( vv, ss, weightSum );
        this.vertices.put( vv, ret );
        return ret;
    }
    
    public Collection<AbstractVertex> getVertices() {
    	return this.vertices.values();
    }
    
    public SPTVertex getVertex( Vertex vv ) {
        return (SPTVertex)this.vertices.get( vv );
    }

	public GraphPath getPath(Vertex dest) {
	    SPTVertex end = this.getVertex( dest );
	    if( end == null ) {
	        return null;
	    }
	    
	    GraphPath ret = new GraphPath();
	    while( true ) {
	        ret.vertices.add( 0, end );
	        if( end.incoming == null ) {
	            break;
	        }
	        end = end.incoming.fromv;
	    }
	    
	    return ret;
	}
}