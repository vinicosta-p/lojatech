CREATE TABLE product (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    price DECIMAL NOT NULL, 
    freight DECIMAL NOT NULL,
    description TEXT, 
    image TEXT,  
    estimated_time TEXT, 
    is_available BOOLEAN NOT NULL
);