import numpy as np

mat_a = np.array([[2, 3], [1, 4]])

# Determinant of a matrix
# It's a scalar value
# Provides information about the matrix
# If det(A) = 0, then A is singular matrix
# If det(A) != 0, then A is non-singular matrix
# If A is non-singular matrix, then A^-1 exists
# det(A) = a*d - b*c
# det(A) = 2*4 - 3*1 = 8 - 3 = 5
# Applies to square matrix only

dtm = np.linalg.det(mat_a)
print("matrix A: \n", mat_a)
print("determinannt of matrix is: ", dtm)

# Inverse of a matrix
# If A is non-singular matrix, then A^-1 exists
# A * A^-1 = I
# A^-1 * A = I
# A^-1 = 1/det(A) * adj(A)
# adj(A) = adjugate of matrix A (https://www.youtube.com/watch?v=wPieefL-5uQ)
# adjugate of matrix A = transpose of cofactor matrix of A
# cofactor matrix of A = matrix of determinants of minors of A
# minor of A = determinant of matrix A without row and column of element
# adj(A) = [[d, -b], [-c, a]]
# A^-1 = 1/5 * [[4, -3], [-1, 2]]
# A^-1 = [[0.8, -0.6], [-0.2, 0.4]]
# having a mtrix [[a, b], [c, d]]
# minor of any element in this matrix can be calulated as
#    a) for element in row 1 and column 1
#    b) remove all the elements in row 1 and column 1
#    c) calculate determinant of remaining matrix
#    d) minor of element = determinant of remaining matrix
#    e) here minor for a is determinant of [[d]]
#    f) here minor for b is determinant of [[c]]
#    g) here minor for c is determinant of [[b]]
#    h) here minor for d is determinant of [[a]]
# cofactor of matrix = [[d, -b], [-c, a]]
#    i) cofactor of element = (-1)^(row+column) * minor of element
#    j) here cofactor for a is (-1)^(1+1) * minor of a = 1 * d = d
#    k) here cofactor for b is (-1)^(1+2) * minor of b = -1 * c = -c
#    l) here cofactor for c is (-1)^(2+1) * minor of c = -1 * b = -b
#    m) here cofactor for d is (-1)^(2+2) * minor of d = 1 * a = a
# adjugate of matrix = [[d, -b], [-c, a]]
#    n) adjugate of matrix = transpose of cofactor matrix
#    o) adjugate of matrix = [[d, -c], [-b, a]]
inv = np.linalg.inv(mat_a)
print("inverse of matrix A: \n", inv)

# Eigne values and vectors
# Eigen values and vectors are used in PCA (Principal Component Analysis)
# Eigen values are scalar values
# Eigen vectors are vectors
# A * v = lambda * v
# A is matrix
# v is eigen vector
# lambda is eigen value
# A * V = V * L
# V is matrix of eigen vectors
# L is matrix of eigen values
# A = V * L * V^-1
# A = V * L * V^T
# A = matrix
# V = matrix of eigen vectors
# L = matrix of eigen values
# V^-1 = inverse of matrix V
# V^T = transpose of matrix V
# mat_a = [[2, 3], [1, 4]]
# eigen values = [5, 1]
# eigen vectors = [[0.85065081, -0.52573111], [0.52573111, 0.85065081]]
eig_v, eig_vt = np.linalg.eig(mat_a)
print("eigen values: ", eig_v)
print("eigen vectors: \n", eig_vt)

# Matrix Decomposition
# Breaking down a matrix into smaller matrices

# Singular Value Decomposition (SVD)
# SVD is used in PCA (Principal Component Analysis)
# SVD is used in image compression
# SVD is used in recommendation systems
# SVD is used in natural language processing
# SVD is used in collaborative filtering
# SVD is used in latent semantic analysis
# SVD is used in latent semantic indexing
# SVD decomposes a matrix into three matrices
# A = U * S * V^T
# A is matrix
# U is matrix of left singular vectors
# S is matrix of singular values
# V^T is transpose of matrix of right singular vectors
# U is orthogonal matrix
    # A matrix is orthogonal if its transpose is equal to its inverse
    # U^T * U = I
# S is diagonal matrix
# V^T is orthogonal matrix
# S is singular values
# S is non-negative values
# S is sorted in descending order
# S is square matrix
# S is same size as A
# S is same size as U
# S is same size as V^T

svd_A = np.array([[2, 3], [1, 4]])
U, S, VT = np.linalg.svd(svd_A)
print("U: \n", U)
print("S: \n", S)
print("VT: \n", VT)




# Excersise
# 1. Create a 3x3 matrix and calculate its determinant
a33 = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
det_a33 = np.linalg.det(a33)
print("determinant of 3x3 matrix: ", det_a33)
# 2. Create a 3x3 matrix and calculate its inverse
a33_inv = np.linalg.inv(a33)
print("inverse of 3x3 matrix: \n", a33_inv)
# 3. Create a 3x3 matrix and calculate its eigen values and vectors
a33_eig_v, a33_eig_vt = np.linalg.eig(a33)
print("eigen values of 3x3 matrix: ", a33_eig_v)
print("eigen vectors of 3x3 matrix: \n", a33_eig_vt)
# 4. Create a 3x3 matrix and calculate its SVD
a33_svd = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
U, S, VT = np.linalg.svd(a33_svd)
print("U of 3x3 matrix: \n", U)
print("S of 3x3 matrix: \n", S)
print("VT of 3x3 matrix: \n", VT)


# Reconstruct the matrix from U, S and VT
# A = U * S * VT

Su = np.zeros((U.shape[0], VT.shape[0]))
np.fill_diagonal(Su, S)
reconstructed_matrix = np.dot(U, np.dot(Su, VT))
print("Reconstructed matrix: \n", reconstructed_matrix)
# Check if the reconstructed matrix is equal to the original matrix
is_equal = np.allclose(reconstructed_matrix, a33_svd)
print("Is the reconstructed matrix equal to the original matrix? ", is_equal)