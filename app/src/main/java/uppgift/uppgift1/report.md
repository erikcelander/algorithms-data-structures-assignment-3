# Comparative Analysis of QuickSort Algorithm Performance at Varying Depths

## Introduction
This report presents an in-depth analysis of the QuickSort algorithm's performance when varying the recursion depth. By examining the algorithm's efficiency across different dataset sizes, this study aims to determine the optimal recursion depth for maximizing sorting speed.

## Methodology
### Experimental Setup
- **Algorithm**: QuickSort with variable recursion depth.
- **Dataset Sizes**: 1999, 4001, 7993, 16001, 32003 integers.
- **Recursion Depth**: Varied from 0 to 30.
- **Performance Metrics**: Median execution time for each depth and dataset size.
- **Repetitions**: Each sorting operation is repeated 30 times.
- **Data Nature**: Randomly generated integers, ensuring diverse sorting scenarios.

### Execution Procedure
- **Data Generation**: Random integer lists are generated for each dataset size.
- **Sorting Execution**: The QuickSort algorithm is executed with each depth level on every dataset size, and the median execution time is recorded.

## Results and Analysis
### Performance Across Depths
- **Shallow Depths (0-2)**: Longer execution times, indicating inefficiency in extremely shallow recursions.
- **Intermediate Depths (3-7)**: Marked decrease in execution times, suggesting optimal performance in this range.
- **Deeper Depths (8-30)**: Gradual increase in execution times, showing diminishing returns with deeper recursions.

### Performance Across Dataset Sizes
- **Small to Medium Datasets (1999 to 16001)**: Consistent improvement in performance with optimal depth levels.
- **Large Dataset (32003)**: Significant efficiency gains at intermediate depths, but increased sensitivity to depth changes.

### Optimal Depth Observation
- **General Trend**: The lowest execution times are typically achieved at depths slightly shallower than logarithmic depth, especially for larger datasets.

## Comparative Insights
- **Depth Optimization**: The experiment demonstrates the critical impact of recursion depth on QuickSort's performance. Optimal depths lead to significant efficiency improvements, particularly in larger datasets.
- **Depth vs. Dataset Size**: Larger datasets benefit more from depth optimization, underlining the importance of adaptively setting recursion depths based on data size.

## Conclusion
This analysis highlights the significance of carefully choosing the recursion depth in QuickSort algorithms. It reveals that there is an optimal range of recursion depths that significantly enhances sorting performance, especially for larger datasets. Understanding these nuances can lead to more efficient sorting implementations in practical applications.
