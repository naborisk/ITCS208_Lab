import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class FullBinaryTreeTester {
	
	public static void inOrderTraverse(Node root)
	{
		//YOUR CODE GOES HERE
		if (root != null){
			inOrderTraverse(root.left);
			System.out.print(root.id + " ");
			inOrderTraverse(root.right);
		}

	}
	
	public static boolean isFullBinTree(Node root)
	{	//YOUR CODE GOES HERE

		if(root != null){
			if((root.left != null && root.right == null) || (root.left == null && root.right != null)){
				return false;
			}else{
				return isFullBinTree(root.left) && isFullBinTree(root.right);
			}
		}
		return true;
	}
	
	public static void normalTester()
	{
		Node[] ts = new Node[7];
		int count = 0;
		ts[count++] = null;
		ts[count++] = new Node(16, null, null);
		
		ts[count++] = new Node(16, new Node(14, null, null), null);
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, null, null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				null);
		
		for(int i = 0; i < ts.length; i++)
		{
			System.out.print("[T"+i+"] in-order: ");
			inOrderTraverse(ts[i]);
			System.out.println("\n[T"+i+"] is"+(isFullBinTree(ts[i])?" ":" NOT ")+"a full binary tree.\n");
		}
		
	}
	
	
	/**************BONUS STARTS***************/
	// 1 3 4 6 7 8 10
	public static void printBinTree(Node root)
	{	//YOUR BONUS CODE GOES HERE
		if(root != null) {
			List<Node> currentLevel = new LinkedList<>();
			currentLevel.add(root);

			while(!currentLevel.isEmpty()) {
				List<Node> nextLevel = new LinkedList<>();

				for(Node node: currentLevel){
					if(node.left != null) nextLevel.add(node.left);
					if(node.right != null) nextLevel.add(node.right);
					System.out.print(node.id + " ");
				}

				System.out.println();
				currentLevel = nextLevel;
			}
		}
	}
	
	public static Node getBinSearchTree(Node root)
	{	//YOUR BONUS CODE GOES HERE

		//System.out.println(nodeToList(root).toArray());
		List<Node> nodeList = nodeToList(root);
		nodeList.sort(Comparator.comparingInt(Node::getId));
		Node[] nodeArray = nodeList.toArray(new Node[nodeList.size()]);

		return toBST(nodeArray, 0, nodeArray.length-1);
	}

	public static List<Node> allNode = new LinkedList<Node>();
	public static List<Node> nodeToList(Node root){
		if (root != null){
			nodeToList(root.left);
			//System.out.print(root.id + " ");
			allNode.add(root);
			nodeToList(root.right);
		}
		return allNode;
	}

	public static Node toBST(Node[] nodeArray, int start, int end){
		if(nodeArray == null || nodeArray.length == 0 || start>end) return null;

		int i = (start+end)/2;
		Node node = new Node(nodeArray[i].id, null, null);
		node.left = toBST(nodeArray, start, i-1);
		node.right = toBST(nodeArray, i+1, end);

		return node;
	}

	public static void bonusTester()
	{
		Node t = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		System.out.println("Before Transforming: ");
		printBinTree(t);
		System.out.println("After Transforming: ");
		printBinTree(getBinSearchTree(t));
		
	}
	/**************BONUS ENDS***************/
	
	
	
	public static void main(String[] args)
	{
		normalTester();
		
		//Uncomment for bonus
		bonusTester();
	}
}
