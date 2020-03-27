package adt;



public interface AbstractDataType<Type> {
	
	// Methods of ADT
	public boolean Add(Type data);
	public boolean Remove(Type data);
	public Object IsElement(Type data);
	public boolean SetEmpty();
	public int SetSize();
	public AbstractDataType<Type> Union(AbstractDataType<Type> T);
	public AbstractDataType<Type> Intersection(AbstractDataType<Type> T);
	public AbstractDataType<Type> Difference(AbstractDataType<Type> T);
	public boolean IsSubsetOf(AbstractDataType<Type> T);
	
}
