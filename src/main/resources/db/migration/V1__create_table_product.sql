CREATE TABLE product (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    category TEXT NOT NULL,
    shop_id TEXT,
    price DECIMAL NOT NULL, 
    promotion_price DECIMAL,
    freight TEXT NOT NULL,
    description TEXT, 
    image TEXT,  
    estimated_time TEXT, 
    quantity INTEGER NOT NULL,
    is_available BOOLEAN NOT NULL
);