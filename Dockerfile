# Use the official PostgreSQL image from the Docker Hub
FROM postgres:latest

# Set environment variables for the default admin user and database
ENV POSTGRES_DB glowboarddb
ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD adminpassword