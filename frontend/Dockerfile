# Stage 1: Build Angular app
FROM node:18-alpine AS builder
WORKDIR /app
COPY . . 
RUN npm install
RUN npm run build

# Stage 2: Serve avec NGINX
FROM nginx:alpine
COPY --from=builder /app/dist/frontend /usr/share/nginx/html
