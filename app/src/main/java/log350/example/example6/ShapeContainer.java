
package log350.example.example6;

import android.text.Spannable;

import java.util.ArrayList;

class ShapeContainer {
	public ArrayList< Shape > shapes = new ArrayList< Shape >();

	public Shape getLastShape() {
		if(shapes.size() >0)
			return shapes.get(shapes.size()-1);
		return null;
	}

	public Shape getShape( int index ) { return shapes.get(index); }

	public void addShape( ArrayList< Point2D > points /* in world space */ ) {
		Shape s = new Shape( points );
		shapes.add( s );
	}

	public void replaceShape(ArrayList< Point2D > points){
		Shape s = new Shape(points);
		if(shapes.size() > 0 ){
			shapes.set(0,s);
		}
		else{
			shapes.add(s);
		}
	}

	// returns -1 if no shape contains the given point
	public int indexOfShapeContainingGivenPoint( Point2D p /* in world space */ ) {
		for ( int i = 0; i < shapes.size(); ++i ) {
			Shape s = shapes.get(i);
			if ( s.contains(p) )
				return i;
		}
		return -1;
	}

	public void draw( GraphicsWrapper gw, int indexOfShapeToHighlight /* -1 for none */ ) {
		for ( int i = 0; i < shapes.size(); ++i ) {
			Shape s = shapes.get(i);
			s.draw(gw, i==indexOfShapeToHighlight );
		}
	}

	public AlignedRectangle2D getBoundingRectangle() {
		AlignedRectangle2D rect = new AlignedRectangle2D();
		for ( Shape s : shapes )
			rect.bound( s.getBoundingRectangle() );
		return rect;
	}
}

