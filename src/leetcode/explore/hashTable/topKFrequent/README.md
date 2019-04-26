# [347. 前K个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/comments/)
    
# Question

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

```
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
```

示例 2:

```java
输入: nums = [1], k = 1
输出: [1]
```

说明：

- 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
- 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

# Solution

### 1. 哈希表 + 优先队列

本题很容易想到**用哈希表键值分别记录数字与其出现的次数**，重点在于取出前`k`个次数最大的数字，需要用到排序的算法。

我们可以借助优先队列来实现，通过构造函数提供自定义的`Comparator`，让优先队列根据`o2.getValue() - o1.getValue()`即**哈希表的值进行排序**，然后遍历`k`次一一从队列中取出即可（**先取出的出现次数较大**）：

```java
public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            // 自定义排序s
            return o2.getValue() - o1.getValue();
        }
    });
    // 将哈希表中 Entry 集合全部加入到优先队列当中
    pq.addAll(map.entrySet());

    for (int i = 0; i < k; i++) {
        res.add(pq.poll().getKey());  // 从队列中取出Entry
    }
    return res;
}
```

### 2. 哈希表 + 分桶法

参考了解答中效率较高的解法：首先同样是用哈希表键值分别记录数字与其出现的次数，然后遍历哈希表的键集合，获取到该数字对应的出现次数（频率）并添加到相应的桶中。最后从后`k`个非空桶中取出所有的数字即为答案：

```java
public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer>[] bucket = new ArrayList[nums.length + 1];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int n : map.keySet()) {
      int frequency = map.get(n);  // 出现的频率
      if (bucket[frequency] == null) { // 初始化
          List<Integer> list = new ArrayList<>();
          bucket[frequency] = list;
      }
      bucket[frequency].add(n); // 将数字加入到桶中
    }

    List<Integer> res = new ArrayList<>();
    for (int i = nums.length; i >= 0 && res.size() < k; i--) {
        if (bucket[i] != null) {
            res.addAll(bucket[i]);
        }
    }
    return res;
}
```

以`[1,1,1,2,2,3]`为例，哈希表的情况为：

```java
// 元素 -> 出现次数
{1=3, 2=2, 3=1}
```

桶的情况为：

```java
// 取出后k个非空桶的所有值，即1和2
[null, [3], [2], [1], null, null, null]
```