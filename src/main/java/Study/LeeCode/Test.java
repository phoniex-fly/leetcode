package Study.LeeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 
 * 注意:
 * 
 * 可以认为区间的终点总是大于它的起点。 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 示例 1:
 * 
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 
 * 输出: 1
 * 
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。 示例 2:
 * 
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 
 * 输出: 2
 * 
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 
 */
public class Test {
	public static void main(String[] args) {
		int[][] intervals = { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };
		Test test = new Test();
		int eraseOverlapIntervals = test.eraseOverlapIntervals(intervals);
	}

	public int eraseOverlapIntervals(int[][] intervals) {
		int num = 0;
		if (intervals.length == 0 || intervals.length == 1) {
			return num;
		}
		List<Node> nodes = new ArrayList<>();
		nodes.add(new Node(intervals[0][0], intervals[0][1]));
		for (int i = 1; i < intervals.length; i++) {
			int currLeft = intervals[i][0];
			int currRight = intervals[i][1];
			boolean flag = false;
			List<Node> newNodes = new ArrayList<>(nodes);
			for (Node node : newNodes) {
				if ((currLeft >= node.left && currLeft < node.right)
						|| (currRight > node.left && currRight <= node.right)) {
					flag = true;
				}
			}
			if (flag) {
				num++;
				System.out.println(currLeft + "," + currRight);
				continue;
			}
			nodes.add(new Node(intervals[i][0], intervals[i][1]));
		}
		return num;
	}

	class Node {
		int left;
		int right;

		public Node(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}

	}

}
