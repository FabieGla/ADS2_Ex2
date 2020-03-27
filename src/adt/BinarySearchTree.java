package adt;

public class BinarySearchTree extends ADT<Integer> {
	// Create sub class node
	class node<DataType> {
		// Node Attributes
		public node<DataType> left;
		public node<DataType> right;
		public node<DataType> parent;
		public DataType data;
		
		// init node
		public node(DataType data) { 
			this.left = null;
			this.right = null;
			this.parent = null;
			this.data = data;
			}
	}
	
	// Binary Search Tree Attributes
	// Records root
	public node<Integer> root;

	
	// Constructor
	public BinarySearchTree() {
		super();
		root = null;
	}
	
	
	
	public int height(node<Integer> n) {
		if (isNILL(n)) {
			return 0;
		} 
		if (isNILL(n.left) && isNILL(n.right)) {
			return 0;
		}
		return Math.max(height(n.left), height(n.right)) + 1;
	}
	
	// Add implementation
	
	public boolean isNILL(node<Integer> n) {
		
		if (n == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// If present, return false, else return true
	public boolean Add(Integer data) {
		
		node<Integer> z = new node<Integer>(data);
		
		if (IsElement(data) == null) {
			node<Integer> y = null;
			node<Integer> x = root;
			
			while (!isNILL(x)) {
				y = x;
				if (z.data < x.data) {
					x = x.left;
				} else {
					x = x.right;
				}
			}
			
			z.parent = y;
			if (isNILL(y)) {
				root = z;
			} else if (z.data < y.data) {
				y.left = z;
			} else {
				y.right = z;
			}
			
			this.setSize += 1;
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean Remove(Integer data) {
		// Check is data is in list
		node<Integer> z = IsElement(data);
			
		if (z != null) {
			if (isNILL(z.left)) {
				Transplant(z,z.right);
			} else if (isNILL(z.right)) {
				Transplant(z,z.left);
			} else {
				node<Integer> y = Minimum(z.right);
				if (!y.parent.equals(z)) {
					Transplant(y,y.right);
					y.right = z.right;
					y.right.parent = y;
				}
				Transplant(z,y);
				y.left = z.left;
				y.left.parent = y;
			}
			this.setSize -= 1;
			return true;
		} else {
			return false;
		}
		
	}
	
	public node<Integer> Minimum(node<Integer> x) {
		while (!isNILL(x.left)) {
			x = x.left;
		}
		return x;
	}
	
	public void Transplant(node<Integer> u, node<Integer> v) {
		
		if (isNILL(u.parent)) {
			root = v;
		} else if (u.equals(u.parent.left)) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		
		if (!isNILL(v)) {
			v.parent = u.parent;
		}
		
	}
	
	public node<Integer> IsElement(Integer data) {
		return search(root, data);
	}
	
	public node<Integer> search(node<Integer> x, Integer data) {
		while (!isNILL(x) && !data.equals(x.data)) {
			if (data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		return x;
	}
	
	public boolean SetEmpty() {
		return (setSize == 0) ? true : false;
	}
	
	public int SetSize() {
		return setSize;
	}
	
	public void InOrder(node<Integer> x) {
		if (!isNILL(x)) {
			InOrder(x.left);
			System.out.println(x.data);
			InOrder(x.right);
		}
	}
	
	public int[] getSortedArray() {
			int[] arr = new int[this.setSize];
			int index = 0;
			InOrderArray(arr,index,root);
			return arr;
	
	}
	
	public int InOrderArray(int[] arr, int index, node<Integer> x) {
			if (!isNILL(x)) {
				index = InOrderArray(arr, index, x.left);
				arr[index] = x.data;
				index = InOrderArray(arr, index+1, x.right);
			} 
			return index;
		
	}
	
	public BinarySearchTree Union(BinarySearchTree bts2) {
		
		int[] bt1Array = this.getSortedArray();
		int[] bt2Array = bts2.getSortedArray();
		
		int i = 0;
		int j = 0;
		
		BinarySearchTree btsUnion = new BinarySearchTree();
		
		while (i < this.setSize || j < bts2.setSize) {
			
			if (j > bts2.setSize - 1) {
				btsUnion.Add(bt1Array[i]);
				i++;
			} else if (i > this.setSize - 1) {
				btsUnion.Add(bt2Array[j]);
				j++;
			} else if (bt1Array[i] < bt2Array[j]) {
				btsUnion.Add(bt1Array[i]);
				i++;
			} else if (bt1Array[i] > bt2Array[j]) {
				btsUnion.Add(bt2Array[j]);
				j++;
			} else if (bt1Array[i] == bt2Array[j]) {
				btsUnion.Add(bt1Array[i]);
				i++;
				j++;
			}
		}
		return btsUnion;
	}
	
	public BinarySearchTree Intersection(BinarySearchTree bts2) {
		
		int[] bt1Array = this.getSortedArray();
		int[] bt2Array = bts2.getSortedArray();
		
		int i = 0;
		int j = 0;
		
		BinarySearchTree btsInter = new BinarySearchTree();
		
		while (i < this.setSize && j < bts2.setSize) {
			
			if (bt1Array[i] < bt2Array[j]) {
				i++;
			} else if (bt1Array[i] > bt2Array[j]) {
				j++;
			} else if (bt1Array[i] == bt2Array[j]) {
				btsInter.Add(bt1Array[i]);
				i++;
				j++;
			}
		}
		return btsInter;
	}
	
	public BinarySearchTree Difference(BinarySearchTree bts2) {
		
		int[] bt1Array = this.getSortedArray();
		int[] bt2Array = bts2.getSortedArray();
		
		int i = 0;
		int j = 0;
		
		BinarySearchTree btsDifference = new BinarySearchTree();
		
		while (i < this.setSize || j < bts2.setSize) {
			
			if (j > bts2.setSize - 1) {
				btsDifference.Add(bt1Array[i]);
				i++;
			} else if (i > this.setSize - 1) {
				j++;
			} else if (bt1Array[i] < bt2Array[j]) {
				btsDifference.Add(bt1Array[i]);
				i++;
			} else if (bt1Array[i] > bt2Array[j]) {
				
				j++;
			} else if (bt1Array[i] == bt2Array[j]) {
				i++;
				j++;
			}
		}
		return btsDifference;
	}
	
	public boolean Subset(BinarySearchTree bts2) {
		
		if (this.setSize > bts2.setSize) {
			return false;
		}
		
		int[] bt1Array = this.getSortedArray();
		int[] bt2Array = bts2.getSortedArray();
		
		int i = 0;
		int j = 0;
		
		while (i < this.setSize && j < bts2.setSize) {
			
			if ((j >= bts2.setSize - 1) && bt1Array[i] > bt2Array[j]) {
				return false;
			}
			
			if (bt1Array[i] < bt2Array[j]) {
				return false;
			} else if (bt1Array[i] > bt2Array[j]) {
				j++;
			} else if (bt1Array[i] == bt2Array[j]) {
				i++;
			} 
			

			
		}
		return true;
		
	}
	
	public void PrintInOrder() {
		InOrder(root);
	}
	
	public void PrintNodeDetails(node<Integer> node) {
		System.out.print("This is node:" + node.data);
		System.out.print("Left:" + node.left.data + " Right:" + node.right.data);
	}

	public static void main(String args[]) {
		
		BinarySearchTree bts = new BinarySearchTree();
		BinarySearchTree bts2 = new BinarySearchTree();
		

		bts2.Add(1);
		bts2.Add(5);
		bts2.Add(3);
		bts2.Add(3);
		bts2.Add(5);
		bts2.Add(1000);
		bts2.Add(1000);
		bts2.Add(3000);
		bts2.Add(3000);
		bts2.Remove(3000);
		bts2.PrintInOrder();
		
		

		
		
		/*
		bts.PrintInOrder();
		System.out.println(bts.SetSize());
		System.out.println(bts.SetEmpty());
		System.out.println(bts.isNILL(bts.IsElement(0)));
		int[] bts1 = bts.getSortedArray();
		for(int x=0;x<bts.setSize; x++) {System.out.println(bts1[x]);}
		*/
		/*BinarySearchTree btsUnion = bts.Union(bts2);
		btsUnion.PrintInOrder();*/
		/*BinarySearchTree btsIntersect = bts.Intersection(bts2);
		btsIntersect.PrintInOrder();*/
		 BinarySearchTree btsDifference = bts.Difference(bts2);
		//btsDifference.PrintInOrder();
		//bts.PrintInOrder();
		//System.out.println(" ~~~");
		//bts2.PrintInOrder();
		/*boolean btsSubset = bts.Subset(bts2);
		System.out.println(btsSubset);*/
		
	}

}
