package accountsmerge

class Solution {
    class UnionFind(num: Int) {
        var parent: IntArray
        var weight: IntArray
        fun union(a: Int, b: Int) {
            val rootA = root(a)
            val rootB = root(b)
            if (rootA == rootB) {
                return
            }
            if (weight[rootA] > weight[rootB]) {
                parent[rootB] = rootA
                weight[rootA] += weight[rootB]
            } else {
                parent[rootA] = rootB
                weight[rootB] += weight[rootA]
            }
        }

        fun root(a: Int): Int {
            if (parent[a] == a) {
                return a
            }
            parent[a] = root(parent[a])
            return parent[a]
        }

        init {
            parent = IntArray(num)
            weight = IntArray(num)
            for (i in 0 until num) {
                parent[i] = i
                weight[i] = 1
            }
        }
    }

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val size = accounts.size
        val uf = UnionFind(size)

        val emailToId = HashMap<String, Int>()
        for (i in 0 until size) {
            val details = accounts[i]
            for (j in 1 until details.size) {
                val email = details[j]

                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId[email]!!)
                } else {
                    emailToId[email] = i
                }
            }
        }

        val idToEmails = HashMap<Int, MutableList<String>>()
        for (key in emailToId.keys) {
            val root = uf.root(emailToId[key]!!)
            if (!idToEmails.containsKey(root)) {
                idToEmails[root] = ArrayList()
            }
            idToEmails[root]!!.add(key)
        }

        val mergedDetails: MutableList<List<String>> = ArrayList()
        for (id in idToEmails.keys) {
            val emails: MutableList<String> = idToEmails[id]!!
            emails.sort()
            emails.add(0, accounts[id][0])
            mergedDetails.add(emails)
        }
        return mergedDetails
    }
}

