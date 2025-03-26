import numpy as np

mat_a = np.array([[2, 3], [1, 4]])

dtm = np.linalg.det(mat_a)
print("matrix A: \n", mat_a)
print("determinannt of matrix is: ", dtm)

inv = np.linalg.inv(mat_a)
print("inverse of matrix A: \n", inv)

eig_v, eig_vt = np.linalg.eig(mat_a)
print("eigen values: ", eig_v)
print("eigen vectors: \n", eig_vt)