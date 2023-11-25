
# SheroozDrive
### Start the Application with the help of Docker
Go to the project directory and execute the following command in the terminal
```
docker network create sherooz-network
docker-compose up
```

### Swagger ui url
```
http://localhost:8000/swagger-ui/index.html
```
### Just run MongoDB in a Docker container
```
docker network create sherooz-network

docker run -d --network sherooz-network --name mongo \
	-e MONGO_INITDB_ROOT_USERNAME=root \
	-e MONGO_INITDB_ROOT_PASSWORD=root \
	-e MONGO_INITDB_DATABASE=sherooz \
	-p 27017:27017 \
	mongo:4.4

docker run -d --network sherooz-network --name sherooz \
    -e SERVER_PORT=8000 \
    -e SPRING_PROFILES_ACTIVE=prod \
    -e SPRING_APPLICATION_NAME=$APP_NAME \
    -e SPRING_DATA_MONGODB_AUTHENTICATION_DATABASE=sherooz \
    -e SPRING_DATA_MONGODB_AUTO_INDEX_CREATION=true \
    -e SPRING_DATA_MONGODB_HOST=mongo \
    -e SPRING_DATA_MONGODB_PORT=27017 \
    -e SPRING_DATA_MONGODB_USERNAME=user1 \
    -e SPRING_DATA_MONGODB_PASSWORD=user1 \
    -e SPRING_DATA_MONGODB_DATABASE=sherooz \
    -p 8000:8000 \
	sheroozdrive-web:latest
```
### Create user in Mongo
```
use sherooz
db.createUser({user: "user1", pwd: "user1", roles: [{role: "readWrite", db: "sherooz"}]})
```

# Next.js + Tailwind CSS Example

This example shows how to use [Tailwind CSS](https://tailwindcss.com/) [(v3.2)](https://tailwindcss.com/blog/tailwindcss-v3-2) with Next.js. It follows the steps outlined in the official [Tailwind docs](https://tailwindcss.com/docs/guides/nextjs).

## Deploy your own

Deploy the example using [Vercel](https://vercel.com?utm_source=github&utm_medium=readme&utm_campaign=next-example) or preview live with [StackBlitz](https://stackblitz.com/github/vercel/next.js/tree/canary/examples/with-tailwindcss)

[![Deploy with Vercel](https://vercel.com/button)](https://vercel.com/new/git/external?repository-url=https://github.com/vercel/next.js/tree/canary/examples/with-tailwindcss&project-name=with-tailwindcss&repository-name=with-tailwindcss)

## How to use

Execute [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app) with [npm](https://docs.npmjs.com/cli/init), [Yarn](https://yarnpkg.com/lang/en/docs/cli/create/), or [pnpm](https://pnpm.io) to bootstrap the example:

```bash
npx create-next-app --example with-tailwindcss with-tailwindcss-app
```

```bash
yarn create next-app --example with-tailwindcss with-tailwindcss-app
```

```bash
pnpm create next-app --example with-tailwindcss with-tailwindcss-app
```

Deploy it to the cloud with [Vercel](https://vercel.com/new?utm_source=github&utm_medium=readme&utm_campaign=next-example) ([Documentation](https://nextjs.org/docs/deployment)).

