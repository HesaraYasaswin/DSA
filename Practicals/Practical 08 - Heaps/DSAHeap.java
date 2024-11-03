public class DSAHeap {
    private DSAHeapEntry[] heap;
    private int count;

    public DSAHeap(int maxSize) {
        heap = new DSAHeapEntry[maxSize];
        count = 0;
    }

    public void add(DSAHeapEntry entry) {
        heap[count] = entry;
        trickleUp(count++);
    }

    public DSAHeapEntry remove() {
        DSAHeapEntry root = heap[0];
        heap[0] = heap[--count];
        heap[count] = null;
        trickleDown(0);
        return root;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(heap[i].getPriority() + ", " + heap[i].getValue());
        }
    }

    public void trickleUp(int index) {
        int parentIndex = getParentIndex(index);
        DSAHeapEntry bottom = heap[index];

        while (index > 0 && heap[parentIndex].getPriority() < bottom.getPriority()) {
            heap[index] = heap[parentIndex];
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
        heap[index] = bottom;
    }

    private int getParentIndex(int index) {
    	return (index - 1) / 2;
	}

	public void trickleDown(int index) {
        DSAHeapEntry top = heap[index];
        while (index < count / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            int largerChildIndex;
            if (rightChildIndex < count && heap[rightChildIndex].getPriority() > heap[leftChildIndex].getPriority()) {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }
            if (top.getPriority() >= heap[largerChildIndex].getPriority()) {
                break;
            }
            heap[index] = heap[largerChildIndex];
            index = largerChildIndex;
        }
        heap[index] = top;
    }

    public int getCount() {
        return count;
    }



	
}