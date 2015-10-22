

public class postVisitor implements nodeVisitor{

	@Override
	public void visit(treeNode target) {
		// TODO Auto-generated method stub
		
		if(target.getLeft()!=null)
			target.getLeft().accept(this);
		if(target.getRight()!=null)
			target.getRight().accept(this);
		System.out.println(target.getValue());
	}
}
