number = int(input())
numbers = list(map(int, input().split()))
numbers = list(map(lambda x: x/max(numbers) * 100, numbers))

print(sum(numbers) / len(numbers))