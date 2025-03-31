import sympy as sp


# Derivative is the slope of the tangent line to the curve at a point
# The derivative of a function f(x) at a point x=a is defined as the limit of the average rate of change of the function over an interval as the interval approaches zero.
# The derivative of f(x) is denoted by f'(x) or df/dx
# The derivative of f(x) is defined as:
# f'(x) = lim(h->0) [f(x+h) - f(x)] / h
# The derivative of f(x) at a point x=a is denoted by f'(a) or df/dx|_(x=a)

x = sp.Symbol('x')
f = x**2

derv = sp.diff(f, x)

print("Derivative is : ", derv)

# Partial Derivative is the derivative of a function of multiple variables with respect to one variable, treating all other variables as constants.
# The partial derivative of f(x,y) with respect to x is denoted by ∂f/∂x or fx
# The partial derivative of f(x,y) with respect to y is denoted by ∂f/∂y or fy
y = sp.Symbol('y')
f = x**2 + y**2
partial_derivative_x = sp.diff(f, x)
partial_derivative_y = sp.diff(f, y)
print("Partial Derivative with respect to x is : ", partial_derivative_x)
print("Partial Derivative with respect to y is : ", partial_derivative_y)