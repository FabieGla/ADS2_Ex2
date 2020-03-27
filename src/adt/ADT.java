package adt;

public class ADT<Type> implements AbstractDataType<Type> {

	// Records Set Size
	public int setSize;
	
	//Constructor
	public ADT() {
		setSize = 0;
	}
	
	@Override
	public boolean Add(Type data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Remove(Type data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object IsElement(Type data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean SetEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int SetSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AbstractDataType<Type> Union(AbstractDataType<Type> T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractDataType<Type> Intersection(AbstractDataType<Type> T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractDataType<Type> Difference(AbstractDataType<Type> T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean IsSubsetOf(AbstractDataType<Type> T) {
		// TODO Auto-generated method stub
		return false;
	}

}
