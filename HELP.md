this spring boot application implemented a rewards calculator, which return the rewards points based on the order price.

for orders more than $50 the base rewards is 50 point;
for orders more than $100 each extra dollar worth 2 points.

so order of $120 gets 90 rewards.

http://localhost:8080/rewards/120

{
	orderPrice: 120,
	rewards: 90
}

or you can query the rewards by orders in month counts

http://localhost:8080/rewards?month=3

[
	{
		orderPrice: 123.45,
		rewards: 96
	},
	{
		orderPrice: 56.78,
		rewards: 50
	}
]

build docker image:
docker build -t spring-boot-docker .

run in docker:
docker run -p 8090:8080 spring-boot-docker
