

public class preVisitor implements nodeVisitor{

		public void visit(treeNode target)
		{
			System.out.println(target.getValue()+"0");
			if(target.getLeft()!=null)
				target.getLeft().accept(this);
			if(target.getRight()!=null)
				target.getRight().accept(this);
		}

}
