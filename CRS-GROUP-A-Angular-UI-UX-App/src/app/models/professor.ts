
    
export class Professor {
    private id:number;
	private name:string;
	private departmentId:number;
	private email:string;
	private phone:string;
	private address:string;

	constructor( id:number,
           name:string,
         departmentId:number,
         email:string,
         phone:string,
         address:string) {
            this.id = id;
            this.name=name;
            this.departmentId=departmentId;
            this.email=email;
            this.phone = phone;
            this.address = address;
	}


    /**
     * Getter $address
     * @return {string}
     */
	public get $address(): string {
		return this.address;
	}

    /**
     * Setter $address
     * @param {string} value
     */
	public set $address(value: string) {
		this.address = value;
	}


    /**
     * Getter $id
     * @return {number}
     */
	public get $id(): number {
		return this.id;
	}

    /**
     * Setter $id
     * @param {number} value
     */
	public set $id(value: number) {
		this.id = value;
	}


    /**
     * Getter $departmentId
     * @return {number}
     */
	public get $departmentId(): number {
		return this.departmentId;
	}

    /**
     * Setter $departmentId
     * @param {number} value
     */
	public set $departmentId(value: number) {
		this.departmentId = value;
	}

    /**
     * Getter $name
     * @return {string}
     */
	public get $name(): string {
		return this.name;
	}

    /**
     * Setter $name
     * @param {string} value
     */
	public set $name(value: string) {
		this.name = value;
	}

    /**
     * Getter $email
     * @return {string}
     */
	public get $email(): string {
		return this.email;
	}

    /**
     * Setter $email
     * @param {string} value
     */
	public set $email(value: string) {
		this.email = value;
	}

    /**
     * Getter $phone
     * @return {string}
     */
	public get $phone(): string {
		return this.phone;
	}

    /**
     * Setter $phone
     * @param {string} value
     */
	public set $phone(value: string) {
		this.phone = value;
	}

    

}