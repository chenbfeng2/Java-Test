

public class inVisitor implements nodeVisitor{
	public void visit(treeNode target)
	{
		if(target.getLeft()!=null)
			target.getLeft().accept(this);
		System.out.println(target.getValue()+"0");
		if(target.getRight()!=null)
			target.getRight().accept(this);
		
	}
}
