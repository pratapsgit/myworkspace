import numpy as np


mat_a = np.array([[1, 2], [3, 4]])
mat_b = np.array([[5, 6], [7, 8]])

print("matrix a ")
print(mat_a)


print("matrix b ")
print(mat_b)

print("matrix addition")
c = mat_a + mat_b
print(c)

print("matrix substraction")
c = mat_b - mat_a
print(c)

print("matrix scalar multiplication")
c = mat_a * 2
print(c)

print("identity matrix")
r = np.eye(4)
print(r)

print("zero matrix")
z = np.zeros([4, 4])
print(z)

print("diagonal matrix")
dg = np.diag([1, 5, 7, 9])
print(dg)


#=============Excercises=================

m1 = np.array([[1,2,3], [4,5,6], [7,8,9]])
m2 = np.array([[11, 22, 33], [44, 55, 66], [88, 99, 100]])

print("m1\n", m1)
print("m2\n", m2)

print("m1+m2\n", m1+m2)
print("m2-m1\n", m2-m1)
print("m1*2\n", m1*2)

m3 = np.array([1, 0, -1])
print("m3\n", m3)
print("m1.shape\n", m1.shape)
print("m3.shape\n", m3.shape)
print("m1*m3\n", np.dot(m1, m3))

m4 = np.eye(3,3)
print("3x3 identity matrix (m4)\n", m4)
r = np.dot(m2, m4)
print("m2 * m4\n", r)

m5 = np.zeros([3,3])
print("3x3 zero matrix (m5)\n", m5)

m6 = np.diag([15, 25, 35])
print("3x3 diagonal matrix (m6)\n", m6)