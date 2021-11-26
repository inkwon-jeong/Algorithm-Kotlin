package redundantconnection

class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(2001)
        for (i in parent.indices) parent[i] = i

        for (edge in edges) {
            val f = edge[0]
            val t = edge[1]
            if (find(parent, f) == find(parent, t)) return edge else parent[find(parent, f)] = find(parent, t)
        }

        return IntArray(2)
    }

    private fun find(parent: IntArray, f: Int): Int {
        if (f != parent[f]) {
            parent[f] = find(parent, parent[f])
        }
        return parent[f]
    }
}

