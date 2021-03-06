package mergesort;

import java.util.Arrays;

public class MergeSort {

	public static long mergesort(int[] numList) {

		long countInversions = 0;
		if (numList.length > 1) {
			int middleIndex = numList.length / 2;
			int[] leftArray = Arrays.copyOfRange(numList, 0, middleIndex);
			int[] rightArray = Arrays.copyOfRange(numList, middleIndex, numList.length);
			countInversions += mergesort(leftArray);
			countInversions += mergesort(rightArray);
			countInversions += merge(numList, leftArray, rightArray);
		}
		return countInversions;
	}

	private static long merge(int[] numList, int[] leftArray, int[] rightArray) {

		int leftIndex, rightIndex;
		leftIndex = rightIndex = 0;
		int i = 0;
		long countInversions = 0;
		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				numList[i] = leftArray[leftIndex++];
			} else {
				numList[i] = rightArray[rightIndex++];
				int numRemainingElementsInLeftArray = leftArray.length - leftIndex;
				countInversions = countInversions + numRemainingElementsInLeftArray;
			}
			i++;
		}
		while (leftIndex < leftArray.length) {
			numList[i++] = leftArray[leftIndex++];
		}
		while (rightIndex < rightArray.length) {
			numList[i++] = rightArray[rightIndex++];
		}
		return countInversions;
	}

	public static long countInversions(int[] numList) {

		// Definition of Inversion: If i<j and A[i] > A[j] then we have one inversion
		// We will piggyback on merge sort and each time the right element is
		// copied over to the sorted array in the merge step, we will count and
		// add the number of remaining elements in the left array. This will
		// give us the total number of inversions.
		long numberOfInversions = mergesort(numList);
		return numberOfInversions;
	}
}
