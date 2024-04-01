CREATE TABLE product (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    shop_id TEXT NOT NULL,
    price DECIMAL NOT NULL, 
    promotion_price DECIMAL,
    profit_margin DECIMAL NOT NULL,
    freight DECIMAL NOT NULL,
    description TEXT, 
    image TEXT,  
    estimated_time TEXT, 
    quantity INTEGER NOT NULL,
    is_available BOOLEAN NOT NULL
);