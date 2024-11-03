public class DSAHashTable {
    private DSAHashEntry[] hashArray;
    private int count;
    private int maxSize;
    private final double loadFactorThreshold = 0.75;
    private final double shrinkFactorThreshold = 0.25;
    private final int[] primes = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    public DSAHashTable(int maxSize) {
        this.maxSize = maxSize;
        hashArray = new DSAHashEntry[maxSize];
        count = 0;
    }

    public void put(String key, Object value) {
        if (count >= loadFactorThreshold * maxSize) {
            resize(maxSize * 2);
        }
        int hash = hash(key);
        int index = hash % maxSize;
        int stepSize = 1 + (hash % (maxSize - 2));
        while (hashArray[index] != null && hashArray[index].getState() != DSAHashEntry.State.FREE) {
            if (hashArray[index].getState() == DSAHashEntry.State.USED && hashArray[index].getKey().equals(key)) {
                hashArray[index].setValue(value);
                return;
            }
            index = (index + stepSize) % maxSize;
        }
        hashArray[index] = new DSAHashEntry(key, value);
        count++;
    }

    public Object get(String key) {
        int index = find(key);
        if (index == -1) {
            return null;
        }
        return hashArray[index].getValue();
    }

    public boolean hasKey(String key) {
        return find(key) != -1;
    }

    public void remove(String key) {
        int index = find(key);
        if (index == -1) {
            return;
        }
        hashArray[index].setState(DSAHashEntry.State.PREVIOUSLY_USED);
        count--;
        if (count < shrinkFactorThreshold * maxSize && maxSize > primes[0]) {
            resize(maxSize / 2);
        }
    }

    private int find(String key) {
        int hash = hash(key);
        int index = hash % maxSize;
        int stepSize = 1 + (hash % (maxSize - 2));
        while (hashArray[index] != null) {
            if (hashArray[index].getState() == DSAHashEntry.State.USED && hashArray[index].getKey().equals(key)) {
                return index;
            }
            index = (index + stepSize) % maxSize;
        }
        return -1;
    }

    private void resize(int newMaxSize) {
        DSAHashTable newTable = new DSAHashTable(newMaxSize);
   
        for (DSAHashEntry entry : hashArray) {
            if (entry != null && entry.getState() == DSAHashEntry.State.USED) {
                newTable.put(entry.getKey(), entry.getValue());
            }
        }
        maxSize = newTable.maxSize;
        hashArray = newTable.hashArray;
    }
    
    private int hash(String key) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }
        hashVal %= maxSize;
        if (hashVal < 0) {
            hashVal += maxSize;
        }
        return hashVal;
    }

    private void resize1(int newSize) {
        // Find the next largest prime number greater than or equal to newSize
        int newPrimeIndex = 0;
        while (primes[newPrimeIndex] < newSize) {
            newPrimeIndex++;
        }
        newSize = primes[newPrimeIndex];

        // Create a new hash array with the new size
        DSAHashEntry[] newHashArray = new DSAHashEntry[newSize];

        // Iterate over the current hash array and re-hash each entry into the new hash array
        for (DSAHashEntry entry : hashArray) {
            if (entry != null && entry.getState() == DSAHashEntry.State.USED) {
                // Re-hash the entry into the new hash array
                int hash = hash(entry.getKey());
                int index = hash % newSize;
                int stepSize = 1 + (hash % (newSize - 2));
                while (newHashArray[index] != null) {
                    index = (index + stepSize) % newSize;
                }
                newHashArray[index] = entry;
            }
        }

        // Set the new hash array and maxSize
        hashArray = newHashArray;
        maxSize = newSize;
    }

    public DSAHashEntry[] getAllEntries() {
        DSAHashEntry[] allEntries = new DSAHashEntry[count];
        int entryIndex = 0;
        for (DSAHashEntry entry : hashArray) {
            if (entry != null && entry.getState() == DSAHashEntry.State.USED) {
                allEntries[entryIndex] = entry;
                entryIndex++;
            }
        }
        return allEntries;
    }


}
    

    