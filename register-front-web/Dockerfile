FROM node:18 AS build

WORKDIR /app

COPY register-front-web/package*.json ./

RUN npm install

COPY register-front-web/ ./

RUN npm run build

FROM nginx:alpine

COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 5173

CMD ["nginx", "-g", "daemon off;"]
